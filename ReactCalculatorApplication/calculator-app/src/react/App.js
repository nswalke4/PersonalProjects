// import Goal from './Goal'
import AboutDeveloper from './containers/AboutDeveloper'
import AboutProject from './containers/AboutProject'
import Calculator from './containers/Calculator'

function App() {
  return (
    // <Goal />
    <div className='app'>
      <AboutProject />
      <Calculator />
      <AboutDeveloper />
    </div>
  );
}

export default App;