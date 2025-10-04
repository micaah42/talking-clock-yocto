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
    networkmanager-qt \
    ws2811 \
    tiny-orm \
"

RDEPENDS:${PN} = "\
    qtbase \
    qttools \
    qtmultimedia \
    qtwebsockets \
    qtdeclarative \
    ws2811 \
    networkmanager \
    networkmanager-qt \
    tiny-orm \
    tensorflow \
    tensorflow-lite \
"

SRC_URI = "gitsm://git@github.com/micaah42/talking-clock.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

do_configure:prepend() {
  cd ${WORKDIR}/git
  git submodule update --init --recursive
  cd -
}

#do_install:append() {
#    install -d ${D}/${systemd_unitdir}/system
#    install -m 0644 ${WORKDIR}/git/clockd/clockd.service ${D}/${systemd_unitdir}/system/
#    install -m 0644 ${WORKDIR}/git/clockd/pamon.service ${D}/${systemd_unitdir}/system/
#}

SYSTEMD_SERVICE:${PN} = "clockd.service pamon.service"

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

