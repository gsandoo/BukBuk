import React, { useState, useEffect } from 'react';
import {Route,Switch,BrowserRouter , Link} from 'react-router-dom';
import Service from './Service'
import Home from './Home'
function App() {




   return (
        <>
        <BrowserRouter>
            <Switch>
                <Route path={'/'} exact component={Service}/>
                <Route path={'/service'} component={Service}/>
            </Switch>
        </BrowserRouter>
        </>



      );
    }

export default App;