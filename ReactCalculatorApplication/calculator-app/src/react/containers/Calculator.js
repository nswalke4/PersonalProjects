import AllClearButton from '../components/AllClearButton'
import ClearButton from '../components/ClearButton'
import NumberButton from '../components/NumberButton'
import OtherButton from '../components/OtherButton'
import Screen from '../components/Screen'

const Calculator = () => {
    return (
        <div className="calculator-group">
            <div className="screen-group">
                <Screen />
            </div>
            <div className="button-group">
                <div className="button-top-row">
                    <AllClearButton />
                    <ClearButton />
                    <OtherButton value="&divide;"/>
                </div>
                <div className="button-second-row">
                    <NumberButton value="7" />
                    <NumberButton value="8" />
                    <NumberButton value="9" />
                    <OtherButton value="&times;"/>
                </div>
                <div className="button-third-row">
                    <NumberButton value="4" />
                    <NumberButton value="5" />
                    <NumberButton value="6" />
                    <OtherButton value="-"/>
                </div>
                <div className="button-fourth-row">
                    <NumberButton value="1" />
                    <NumberButton value="2" />
                    <NumberButton value="3" />
                    <OtherButton value="+"/>
                </div>
                <div className="button-bottom-row">
                    <NumberButton value="0" />
                    <NumberButton value="." />
                    <OtherButton value="&equals;" />
                </div>
            </div>
        </div>
    )
}

export default Calculator
