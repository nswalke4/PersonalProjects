import QtQuick 2.0
import StudyRight 1.0

Text {
    id: root

    property bool isRight: false
    property bool isWrong: false

    font.family: Style.family
    font.bold: true
    font.pointSize: Style.sizes.big
    horizontalAlignment: Style.align.hCenter
    verticalAlignment: Style.align.vCenter
    color: {
        if (root.isRight) {
            return Colors.rightText;
        } else if (root.isWrong) {
            return Colors.wrongText;
        } else {
            return Colors.darkText;
        }
    }
}
