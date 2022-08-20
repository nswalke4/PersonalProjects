import QtQuick 2.0
import QtQuick.Layouts 1.0
import StudyRight 1.0

Rectangle {
    id: root
    width: parent.width
    height: parent.height
    anchors.centerIn: parent
    color: Colors.darkBackground

    signal rightBtnClicked
    signal wrongBtnClicked

    ColumnLayout {
        id: layout
        anchors.centerIn: root
        width: root.width
        height: root.height

        Item {
            id: question
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width
            Layout.preferredHeight: root.height * 0.25

            Rectangle {
                id: questionBackground
                radius: 20
                width: question.width
                height: question.height
                anchors.centerIn: question
                color: Colors.midBackground
            }
        }

        Item {
            id: answer
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width
            Layout.preferredHeight: root.height * 0.55
            Layout.fillHeight: true

            Rectangle {
                id: answerBackground
                radius: 20
                width: answer.width
                height: answer.height
                anchors.centerIn: answer
                color: Colors.lightBackground
            }
        }

        Item {
            id: btnArea
            Layout.alignment: Qt.AlignCenter
            Layout.preferredWidth: root.width
            Layout.preferredHeight: root.height * 0.2

            RowLayout {
                id: btnLayout
                width: btnArea.width
                height: btnArea.height
                anchors.centerIn: btnArea

                RightButton {
                    id: rightBtn
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 125
                    Layout.alignment: Qt.AlignHCenter

                    onClicked: { rightBtnClicked() }
                }

                WrongButton {
                    id: wrongBtn
                    Layout.preferredWidth: 400
                    Layout.preferredHeight: 125
                    Layout.alignment: Qt.AlignHCenter

                    onClicked: { wrongBtnClicked() }
                }

            }
        }
    }
}
