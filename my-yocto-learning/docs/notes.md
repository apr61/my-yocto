

## Start the poky container

docker run --rm -it -v ${HOME}/linuxlab/:/workdir my-poky-container

## Run qemu emulator

runqemu qemux86-64 slirp nographic
