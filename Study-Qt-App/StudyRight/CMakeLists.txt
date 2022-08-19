cmake_minimum_required(VERSION 3.16)

project(StudyRight VERSION 0.1 LANGUAGES CXX)

set(CMAKE_AUTOMOC ON)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(Qt6 6.2 COMPONENTS Quick REQUIRED)

qt_add_executable(appStudyRight
    main.cpp
)

qt_add_qml_module(appStudyRight
    URI StudyRight
    VERSION 1.0
    QML_FILES
        qmldir
        main.qml
        src/components/MenuButton.qml
        src/screens/Home.qml
        src/themes/basic/Colors.qml
        src/themes/basic/Style.qml
        src/themes/basic/fonts/HeaderMainText.qml
        src/themes/basic/fonts/HeaderSubText.qml
        src/themes/basic/fonts/MenuButtonText.qml
)

set_target_properties(appStudyRight PROPERTIES
    MACOSX_BUNDLE_GUI_IDENTIFIER my.example.com
    MACOSX_BUNDLE_BUNDLE_VERSION ${PROJECT_VERSION}
    MACOSX_BUNDLE_SHORT_VERSION_STRING ${PROJECT_VERSION_MAJOR}.${PROJECT_VERSION_MINOR}
    MACOSX_BUNDLE TRUE
    WIN32_EXECUTABLE TRUE
)

target_compile_definitions(appStudyRight
    PRIVATE $<$<OR:$<CONFIG:Debug>,$<CONFIG:RelWithDebInfo>>:QT_QML_DEBUG>)
target_link_libraries(appStudyRight
    PRIVATE Qt6::Quick)
