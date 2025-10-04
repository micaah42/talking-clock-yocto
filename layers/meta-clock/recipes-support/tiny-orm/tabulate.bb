LIC_FILES_CHKSUM = "file://LICENSE;md5=82ce504a4a2009f1a25f8b28d8c48313"
LICENSE = "MIT"


SRC_URI[sha256sum] = "b53bb293c53f0c2b4e07553002d00e8b790d44a7b5b6c26d548e0b8c4693b768"
SRC_URI = "git://github.com/p-ranav/tabulate.git;protocol=https;branch=master"
SRCREV = "b35db4cce50a4b296290b0ae827305cdeb23751e"
S = "${WORKDIR}/git"

inherit cmake