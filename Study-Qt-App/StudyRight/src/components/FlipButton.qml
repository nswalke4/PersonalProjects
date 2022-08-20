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
        color: Colors.lightBackground
        border.color: Colors.midBackground
        border.width: 5
    }

    FlashcardButtonText {
        id: fbText
        anchors.centerIn: root
        text: "Flip"
    }

    onClicked: {
        console.log("[ACTION] '" + fbText.text + "' was clicked");
    }
}
