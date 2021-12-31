const ProjectInfo = ({ swapState }) => {
    return (
        <div className="project-info">
            <p>
                Thank you for visiting this web application! This project was completed to become a
                part of my Personal Software Development Portfolio. This is my very first attempt at
                creating a website (using CSS and HTML), as well as using Javascript and React JS.
                Overall, this project is very basic. The website is semi-reactive. However, the
                actual calculator does not resize. In order for the application to work properly,
                the display should be at least 600 pixels wide. As for the calculator: it only has
                basic functionality. The main goal of this application was to test out web
                development and to test my skills in a new language; developing a calculator that
                can do many complicated things was not a main priority.
            </p>
            <h3 onClick={swapState}>Close</h3>
        </div>
    );
};

export default ProjectInfo;
