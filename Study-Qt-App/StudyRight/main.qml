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
//        onFcBtnClicked: {
//            console.log("[ACTION] FlashCard Button Pressed");
//            console.log("  !!NOTICE!! Currently under development, so not entering this view...");
////            root.swapScreen(screens.question);
//        }
//        onImportBtnClicked: {
//            console.log("[ACTION] Import Button Pressed");
//            root.swapScreen(screens.imports);
//        }
    }

//    Question {
//        id: question
//        property int screen: screens.question
//        visible: this.screen === root.curScreen
//        onFlipBtnClicked: {
//            console.log("[ACTION] Flip Button Pressed");
//            root.swapScreen(screens.answer);
//        }
//    }

//    Answer {
//        id: answer
//        property int screen: screens.answer
//        visible: this.screen === root.curScreen
//        onNextBtnClicked: {
//            console.log("[ACTION] Next Button Pressed");
//            root.swapScreen(screens.question);
//        }
//        onResultsBtnClicked: {
//            console.log("[ACTION] Results Button Pressed");
//            root.swapScreen(screens.results);
//        }
//    }

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
