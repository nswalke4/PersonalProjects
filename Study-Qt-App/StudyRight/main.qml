import QtQuick
import StudyRight 1.0

Window {
    id: root
    width: 1920
    height: 1080
    visible: true
    title: qsTr("Hello World")

    QtObject {
        id: screens
        readonly property int home: 1
        readonly property int question: 2
        readonly property int answer: 3
        readonly property int results: 4
        readonly property int imports: 5
    }

    property int curScreen: screens.home

    Home {
        id: home
        property int screen: screens.home
        visible: this.screen === root.curScreen

        onBtnClicked: (text) => {
            console.log("    `from home` " + text + " button clicked");
        }

        onQuestionBtnClicked: {
            console.log("[SCREEN_CHANGE] Entering Question Screen");
            root.swapScreen(screens.question);
        }
    }

    Question {
        id: question
        property int screen: screens.question
        visible: this.screen === root.curScreen

        onFlipBtnClicked: {
            console.log("[SCREEN_CHANGE] Entering Answer Screen");
            root.swapScreen(screens.answer);
        }
    }

    Answer {
        id: answer
        property int screen: screens.answer
        visible: this.screen === root.curScreen
        onRightBtnClicked: {
            console.log("[SCREEN_CHANGE] Entering Question Screen");
            root.swapScreen(screens.question);
        }
        onWrongBtnClicked: {
            console.log("[SCREEN_CHANGE] Entering Home Screen");
            root.swapScreen(screens.home);
        }
    }

//    Results {
//        id: results
//        property int screen: screens.results
//        visible: this.screen === root.curScreen
//        onHomeBtnClicked: {
//            console.log("[ACTION] Home Button Pressed");
//            root.swapScreen(screens.home);
//        }
//    }

//    Import {
//        id: import
//        property int screen: screens.imports
//        visible: this.screen === root.curScreen
//        onHomeBtnClicked: {
//            console.log("[ACTION] Home Button Pressed");
//            root.swapScreen(screens.home);
//        }
//    }

    function swapScreen(newScreen) {
        root.curScreen = newScreen;
    }
}
