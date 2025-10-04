SUMMARY = "Applications & Libraries used to make a Talking Clock"
HOMEPAGE = "https://github.com/micaah42"

LICENSE = "CLOSED"

inherit cmake pkgconfig

SRC_URI = "git://git@github.com/jgarff/rpi_ws281x.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

EXTRA_OECMAKE = " -DBUILD_SHARED=ON"
S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += " ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN} += "\
    /usr/lib/libws2811.so \
"

