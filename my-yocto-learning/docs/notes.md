

## Start the poky container

docker run --rm -it -v ${HOME}/linuxlab/:/workdir my-poky-container

## Run qemu emulator

runqemu qemux86-64 slirp nographic

## Create a layer
bitbake-layers create-layer my_custom_layer

bitbake-layers add-layers my_custom_layer

