cmake_minimum_required(VERSION 2.8...3.1)
project("cpp-cmake-app")

set(${PROJECT_NAME}_SRC_FILES
	${CMAKE_CURRENT_SOURCE_DIR}/src/main.cpp
)

add_executable(${PROJECT_NAME}
	${${PROJECT_NAME}_SRC_FILES}	
)

install(TARGETS cpp-cmake-app DESTINATION bin)
