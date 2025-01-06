SUMMARY = "Applications & Libraries used to make a Talking Clock"
HOMEPAGE = "https://github.com/micaah42"

LICENSE = "CLOSED"

inherit qt6-cmake systemd

DEPENDS += "\
    qtbase \
    qttools \
    qtmultimedia \
    qtwebsockets \
    qtdeclarative \
    qtdeclarative-native \
    nodejs-native \
"

RDEPENDS:${PN} = "\
    qtbase \
    qttools \
    qtmultimedia \
    qtwebsockets \
    qtdeclarative \
"

SRC_URI = "git://git@github.com/micaah42/talking-clock.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/git/clockd/clockd.service ${D}/${systemd_unitdir}/system/
}

SYSTEMD_SERVICE:${PN} = "clockd.service"

# angular application

do_compile:append() {
    # compile and install node modules in source directory
    cd ${WORKDIR}/git/web
    npm clean-install
    npm run build
}

FILES:${PN} += "\
    /usr/share/clockd/* \
    /etc/systemd/system/*.service \
"

