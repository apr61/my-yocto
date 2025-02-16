
SUMMARY = "DLT deamon"
DESCRIPTION = "DLT deamon used to collect dlt logs from apps"
HOMEPAGE = "https://github.com/COVESA/dlt-daemon"

LICENSE = "CLOSED"
#LICENSE = "GPL-2.0-only"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=bbb1234567890abcdef1234567890abcd"

SRC_URI = "git://github.com/COVESA/dlt-daemon.git;nobranch=1;protocol=https"
SRCREV = "d5b425b1e33804d4067cd017ccb718e077fd5ba5"

PV = "1.0"

DEPENDS = "dlt zlib"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=/usr/local \
	-DDLT_USE_IPC=ON"

do_install(){
	install -d ${D}${bindir}
	install -d ${D}/usr/local/etc/
	

	install -m 0755 ${B}/src/daemon/dlt-daemon ${D}${bindir}/dlt-daemon	
	install -m 0644 ${S}/src/daemon/dlt.conf ${D}/usr/local/etc/dlt.conf
}

FILES:${PN} += "${bindir}/dlt-daemon"
FILES:${PN} += "/usr/local/etc/dlt.conf"
