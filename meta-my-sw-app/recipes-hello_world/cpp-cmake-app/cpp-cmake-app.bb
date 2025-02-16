
SUMMARY = "CPP Cmake app"
DESCRIPTION = "CPP cmake cpp working in yocto"
LICENSE = "CLOSED"

SRC_URI = "file://dist"

S = "${WORKDIR}/dist"

DEPENDS = "dlt"

inherit cmake

do_install(){
	install -d ${D}${bindir}
	install -m 0755 ${B}/cpp-cmake-app ${D}${bindir}/cpp-cmake-app
}
