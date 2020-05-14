import React from 'react';
import BaseLayout from "./layouts/BaseLayout";
import {BrowserRouter} from "react-router-dom";

function App() {
    return (
        <div>
            <BrowserRouter>
                {/*<TestLayout/>*/}
                <BaseLayout/>
            </BrowserRouter>
        </div>
    );
}

export default App;
