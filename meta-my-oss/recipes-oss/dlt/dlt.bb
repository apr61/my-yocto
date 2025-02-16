
SUMMARY = "DLT Library"
DESCRIPTION = "DLT library used by apps to send dlt logs to dlt-daemon"
HOMEPAGE = "https://github.com/COVESA/dlt-daemon"

LICENSE = "CLOSED"
#LICENSE = "GPL-2.0-only"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=bbb1234567890abcdef1234567890abcd"

SRC_URI = "git://github.com/COVESA/dlt-daemon.git;nobranch=1;protocol=https"
SRCREV = "d5b425b1e33804d4067cd017ccb718e077fd5ba5"

PV = "1.0"

DEPENDS = "zlib"

S = "${WORKDIR}/git"

inherit cmake 

EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr/local \
	-DDLT_USE_IPC=ON"

do_install(){
	install -d ${D}/usr/local/include/dlt
	install -d ${D}/usr/local/lib

	install -m 0644 ${B}/src/lib/libdlt.so.2.18.10 ${D}/usr/local/lib
	
	ln -sf libdlt.so.2.18.10 ${D}/usr/local/lib/libdlt.so.2	
	ln -sf libdlt.so.2 ${D}/usr/local/lib/libdlt.so	
	
	install -m 0644 ${S}/include/dlt/dlt* ${D}/usr/local/include/dlt
}

FILES:${PN} += "/usr/local/include/dlt"

FILES:${PN} += "/usr/local/lib/libdlt.so*"
FILES:${PN}-dev = "/usr/local/lib/libdlt.so*"


SOLIBS = ".so"
FILES_SOLIBDEV = ""
INSANE_SKIP:${PN} = "dev-so"
