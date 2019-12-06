# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "https://github.com/ejurgensen/forked-daapd/releases/download/${PV}/forked-daapd-${PV}.tar.xz"
SRC_URI[md5sum] = "5bab6ea3ddd59ec8b92e96b08094052f"
SRC_URI[sha256sum] = "04a5ce79971ec34d8283502a16324b02ce647a4eeaf8fde634d077f2ec6ecfc6"

S = "${WORKDIR}/forked-daapd-${PV}"

# NOTE: unable to map the following pkg-config dependencies: libavcodec libevent libavcodec-libav json-c
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "libgcrypt libunistring zlib confuse libmxml sqlite3 libevent json-c libantlr3c ffmpeg avahi libplist libsodium libwebsockets"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools gettext

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} += "${libdir}/forked-daapd/forked-daapd-sqlext.so ${datadir}/forked-daapd/htdocs/* /run"

