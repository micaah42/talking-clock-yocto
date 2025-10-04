LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5dc23d5193abaedb6e42f05650004624"

SRC_URI = "git://github.com/ericniebler/range-v3.git;protocol=https;branch=master"

SRCREV = "a81477931a8aa2ad025c6bda0609f38e09e4d7ec"

S = "${WORKDIR}/git"

DEPENDS = "boost"
RDEPENDS_${PN}-dev = ""

inherit cmake