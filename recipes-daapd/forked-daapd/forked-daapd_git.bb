LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/chme/forked-daapd.git;protocol=https;branch=yocto_zeus \
           file://0001-Disable-creation-of-log-and-run-directories.patch \
           file://forked-daapd.service \
          "

PV = "27.0+git${SRCPV}"
SRCREV = "33f97f55f39287aec1f8f5623b6003e0312f36ca"

S = "${WORKDIR}/git"

DEPENDS = "libgcrypt libunistring zlib confuse libmxml sqlite3 libevent json-c libantlr3c ffmpeg avahi libplist libsodium libwebsockets \
           gperf-native antlr3-native \
          "
RDEPENDS_${PN} += "libgcc"

inherit pkgconfig autotools-brokensep gettext useradd systemd

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--disable-dependency-tracking"

do_install_append() {
    chown -R daapd:daapd ${D}/${localstatedir}/cache/forked-daapd/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/forked-daapd.service ${D}${systemd_system_unitdir}/forked-daapd.service
}

FILES_${PN} += "${libdir}/forked-daapd/forked-daapd-sqlext.so ${datadir}/forked-daapd/htdocs/* /run ${systemd_system_unitdir}/forked-daapd.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/cache/forked-daapd \
    --groups audio \
    --user-group daapd"

SYSTEMD_SERVICE_${PN} = "forked-daapd.service"
