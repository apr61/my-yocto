

## Start the poky container

docker run --rm -it -v ${HOME}/linuxlab/:/workdir my-poky-container

## Run qemu emulator

runqemu qemux86-64 slirp nographic

## Create a layer
bitbake-layers create-layer my_custom_layer

bitbake-layers add-layers my_custom_layer


## Recipe

SUMMARY = "Hello world cpp app"
DESCRIPTION = "A simple cpp application"
LICENSE = "CLOSED"

SRC_URI = "file://main.cpp"

# PN - package name (automatically set by receipe name)
# PV - Package version

PV = "0.1"

# S - Source directory
# Defines where the source code will be extracted or located during build process
# ${WORKDIR}/${PN}-${PV} (e.g., /tmp/work/.../myapp/1.0-r0/myapp-1.0)

S = "${WORKDIR}"

do_compile(){
        ${CXX} ${LDFLAGS}  -o helloworld main.cpp
}

# D - Destination directory for installation
# Represents the root of the target filesystem inside the build system.
# Used in do_install() to specify where files should be placed before packaging.
# ${D}${bindir} expands to something like /tmp/work/.../image/usr/bin/
# ${B} is automatically set by BitBake to point to the directory where the package is being built, defaults ${WORKDIR}/build

# bindir - /usr/bin (For binaries)
# libdir - /usr/lib (for libraries)
# sbindir - /usr/sbin (for system binaries)
# includedir - /usr/include (for headers)
# sysconfdir - /etc


# -d, will create the director
# -m, is used to set the permissions
do_install(){
        install -d ${D}${bindir}
        install -m 0755 helloworld ${D}${bindir}/helloworld
}

FILES:${PN} += "${bindir}/helloworld"


## What does /tmp/work dir contains?

It contains workspaces for different architectures and targets

For example

all-poky-linux, core2-64-poky-linux, qemux86_64-poky-linux, x86_64-linux

#### all-poky-linux

- This contains recipes and tasks that are architecture-independent.
	Examples:
		- Documentation packages
        	- Scripts
        	- Configuration files that don't depend on CPU architecture

#### qemux86_64-poky-linux (for qemu specific)

- This is for QEMU x86_64 emulation.
- Used when you are building an image to run in QEMU (MACHINE="qemux86-64" in local.conf).
- Similar to core2-64, but specifically optimized for the QEMU virtualized environment.

#### x86_64-linux

- This is for native build tools running on the host (your development machine).
    Includes tools like:
        gcc (cross-compiler)
        binutils
        qemu-native
- These tools run on your host machine (which is x86_64) but are used to build for different targets.

#### core2-64-poky-linux (target specific)

- This is for target-specific builds.
- core2-64 refers to a 64-bit Intel (x86_64) target based on the Intel Core 2 CPU family.
- Contains compiled binaries, libraries, and intermediate build files.

