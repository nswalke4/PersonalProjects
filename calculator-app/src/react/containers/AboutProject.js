import ProjectInfo from "../components/ProjectInfo";
import {useState} from "react";

const AboutProject = () => {
    const [moreInfo, setMoreInfo] = useState(false);

    const swapInfoState = () => {
        setMoreInfo(!moreInfo);
    }

    return (
        <div className="about-project">
            <h2>Nicholas Walker's</h2>
            <h1>Basic Calculator Application</h1>
            {moreInfo && <ProjectInfo swapState={swapInfoState} />}
            {!moreInfo && <h3 onClick={swapInfoState}>About this Project</h3>}
        </div>
    );
};

export default AboutProject;
