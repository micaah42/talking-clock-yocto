SUMMARY = "TinyORM: Qt/C++ Object relational mapper"
HOMEPAGE = "https://www.tinyorm.org"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03ca4880df7540bc3c3c73c52b573c94"

inherit qt6-cmake

DEPENDS += "\
    qtbase \
    ccache \
    range-v3 \
    tabulate \
"

RDEPENDS:${PN} = "\
    qtbase \
    ccache \
"

SRC_URI = "git://git@github.com/silverqx/TinyORM.git;protocol=https;branch=main"
SRCREV = "d568759812199c095f5a7c96d5111264a8f1ac83"
S = "${WORKDIR}/git"

OE_EXTRA_CMAKE = "\
    MYSQL_PING=OFF \
    BUILD_MYSQL_DRIVER=OFF \
    BUILD_DRIVERS=OFF \
"