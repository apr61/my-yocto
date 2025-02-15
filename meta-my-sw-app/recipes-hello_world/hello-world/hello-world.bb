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

