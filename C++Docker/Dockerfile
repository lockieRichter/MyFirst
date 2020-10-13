FROM ubuntu:bionic

RUN apt-get update && \
    apt-get install -y build-essential git cmake autoconf libtool pkg-config

WORKDIR /src

COPY CMakeLists.txt hello.cpp catch.hpp ./

RUN cmake . && make

CMD ["./helloworld"]