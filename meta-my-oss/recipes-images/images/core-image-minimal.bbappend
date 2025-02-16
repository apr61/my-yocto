
DESCRPTION = "A core image file for core-image-minimal"
LICENSE = "MIT"

IMAGE_ROOTFS_SIZE = "100192"

IMAGE_INSTALL_append = " hello-world"
IMAGE_INSTALL_append = " cpp-cmake-app"
IMAGE_INSTALL_append = " dlt"
IMAGE_INSTALL_append = " dlt-daemon"
