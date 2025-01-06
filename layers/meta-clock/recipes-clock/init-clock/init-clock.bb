SUMMARY = "Scripts and service to initialize Talking Clock on first boot"
HOMEPAGE = "https://github.com/micaah42"

LICENSE = "CLOSED"

REDEPENDS:${PN} = "bash"

SRC_URI = " \
    file://init-clock.sh \
    file://init-clock.service \
"

inherit systemd
SYSTEMD_SERVICE:${PN} = "init-clock.service"

do_install:append() {
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/init-clock.service ${D}/${systemd_unitdir}/system/

    install -d ${D}/usr/share/clockd
    install -m 755 ${WORKDIR}/init-clock.sh ${D}/usr/share/clockd/
}

FILES:${PN} = "\
  ${systemd_unitdir}/system/init-clock.service \
  /usr/share/clockd/init-clock.sh \
"