FROM ubuntu:20.04

# Set the timezone environment variable
ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Kolkata

# Install necessary packages, including locale support
RUN apt-get update && apt-get install -y \
    tzdata \
    locales \
    gawk \
    wget \
    git-core \
    diffstat \
    unzip \
    texinfo \
    gcc-multilib \
    build-essential \
    chrpath \
    socat \
    cpio \
    python3 \
    python3-pip \
    python3-pexpect \
    xz-utils \
    debianutils \
    iputils-ping \
    python3-git \
    python3-jinja2 \
    libegl1-mesa \
    libsdl1.2-dev \
    pylint3 \
    xterm \
    python3-subunit \
    mesa-common-dev \
    python-dev \
    vim \
    && apt-get clean

# Generate the en_US.UTF-8 locale
RUN locale-gen en_US.UTF-8 && update-locale LANG=en_US.UTF-8

# Create a non-root user
RUN useradd -ms /bin/bash pokyuser

# Switch to the non-root user
USER pokyuser

# Set the working directory
WORKDIR /home/pokyuser/workdir

# Your additional setup commands here

CMD ["/bin/bash"]

