/*
This is a UI file (.ui.qml) that is intended to be edited in Qt Design Studio only.
It is supposed to be strictly declarative and only uses a subset of QML. If you edit
this file manually, you might introduce QML code that is not supported by Qt Design Studio.
Check out https://doc.qt.io/qtcreator/creator-quick-ui-forms.html for details on .ui.qml files.
*/

import QtQuick
import QtQuick.Controls
import StudyApplication

Rectangle {
    id: root
    width: Constants.width
    height: Constants.height

    color: Constants.backgroundColor
    property alias importBtn: importBtn
    property alias unavailableBtn6: unavailableBtn6
    property alias unavailableBtn5: unavailableBtn5
    property alias unavailableBtn4: unavailableBtn4
    property alias unavailableBtn3: unavailableBtn3
    property alias unavailableBtn2: unavailableBtn2
    property alias unavailableBtn1: unavailableBtn1
    property alias flashcardBtn: flashcardBtn

    Rectangle {
        id: titleRect
        x: 210
        y: 50
        width: 1500
        height: 160
        color: "#00ffffff"

        Text {
            id: titleText
            x: 0
            y: 0
            width: 1500
            height: 100
            text: qsTr("Welcome to the Study Helper Application!!")
            font.pixelSize: 70
            horizontalAlignment: Text.AlignHCenter
            verticalAlignment: Text.AlignVCenter
            font.weight: Font.Bold
            font.bold: true
        }

        Text {
            id: subtitleText
            x: 0
            y: 100
            width: 1500
            height: 60
            color: "#1b3c62"
            text: qsTr("<Currently Under Development>")
            font.pixelSize: 45
            horizontalAlignment: Text.AlignHCenter
            verticalAlignment: Text.AlignVCenter
            font.italic: true
        }
    }

    Rectangle {
        id: optionsRectangle
        x: 160
        y: 260
        width: 1600
        height: 720
        color: "#1b3c62"

        Button {
            id: flashcardBtn
            x: 100
            y: 64
            width: 650
            height: 100
            text: qsTr("Flashcards")
            font.bold: true
            font.pointSize: 42
        }

        Button {
            id: unavailableBtn1
            x: 850
            y: 64
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.italic: true
            font.pointSize: 42
            font.bold: true
        }

        Button {
            id: unavailableBtn2
            x: 100
            y: 228
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.pointSize: 42
            font.bold: true
            font.italic: true
        }

        Button {
            id: unavailableBtn3
            x: 850
            y: 228
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.pointSize: 42
            font.bold: true
            font.italic: true
        }

        Button {
            id: unavailableBtn4
            x: 100
            y: 392
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.pointSize: 42
            font.bold: true
            font.italic: true
        }

        Button {
            id: unavailableBtn5
            x: 850
            y: 392
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.pointSize: 42
            font.bold: true
            font.italic: true
        }

        Button {
            id: unavailableBtn6
            x: 100
            y: 556
            width: 650
            height: 100
            text: qsTr("<unavailable>")
            font.pointSize: 42
            font.bold: true
            font.italic: true
        }

        Button {
            id: importBtn
            x: 850
            y: 556
            width: 650
            height: 100
            text: qsTr("Import Terms")
            font.pointSize: 42
            font.bold: true
        }
    }

    Rectangle {
        id: aboutRect
        x: 360
        y: 1000
        width: 1200
        height: 60
        color: "#00ffffff"

        Text {
            id: aboutText
            x: 0
            y: 0
            width: 1200
            height: 60
            text: "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n<html><head><meta name=\"qrichtext\" content=\"1\" /><meta charset=\"utf-8\" /><style type=\"text/css\">\np, li { white-space: pre-wrap; }\n</style></head><body style=\" font-family:'Segoe UI'; font-size:9pt; font-weight:400; font-style:normal;\">\n<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:20pt; font-style:italic;\">Developer: Nicholas Walker (nswalke4@asu.edu)   |   Began Aug 2022;  Complete TBD</span></p></body></html>"
            horizontalAlignment: Text.AlignHCenter
            verticalAlignment: Text.AlignVCenter
            font.italic: true
            textFormat: Text.RichText
        }
    }
}

/*##^##
Designer {
    D{i:0;formeditorZoom:0.5}D{i:1;locked:true}D{i:6}D{i:7}D{i:8}D{i:9}D{i:10}D{i:11}
D{i:12}D{i:4;locked:true}D{i:13;locked:true}
}
##^##*/
