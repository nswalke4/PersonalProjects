import QtQuick 2.0
import QtQuick.Controls 2.0
import StudyRight 1.0

Button {
    id: root
    flat: true

    background: Rectangle {
        implicitWidth: parent.width
        implicitHeight: parent.height
        radius: 15
        color: Colors.wrongBackground
        border.color: Colors.wrongBorder
        border.width: 5
    }

    FlashcardButtonText {
        id: fbText
        anchors.centerIn: root
        text: "Incorrect"
        isWrong: true
    }

    onClicked: {
        console.log("[ACTION] '" + fbText.text + "' was clicked");
    }
}
