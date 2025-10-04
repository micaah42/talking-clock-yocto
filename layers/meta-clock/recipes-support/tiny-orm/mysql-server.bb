LIC_FILES_CHKSUM = "file://LICENSE;md5=90eaa431be7d2edd7f3da4a796087e39"
LICENSE = "GPLv2"
inherit cmake


SRC_URI[sha256sum] = "76d15981cf445bc476fad553fb0be803336e55a1b531a6803ccfa25b7355326e"
SRC_URI = "git://github.com/mysql/mysql-server.git;protocol=https;branch=8.0"
SRCREV = "6ba1fef58b043ac5e9657ded777d20619b9b2f4e"
S = "${WORKDIR}/git"

OE_EXTRA_CMAKE = "\
    -DWITHOUT_SERVER=ON \
    -DWITH_UNIT_TESTS=OFF \
"
