require recipes-core/images/core-image-minimal.bb

DESCRIPTION = "Image containing forked-daapd"

IMAGE_INSTALL += "forked-daapd-dist avahi-daemon"
