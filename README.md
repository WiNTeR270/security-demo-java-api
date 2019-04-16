# Java Spring API IP Search

[![Build Status](https://travis-ci.com/WiNTeR270/security-demo-react-redux.svg?branch=master)](https://travis-ci.com/WiNTeR270/security-demo-react-redux)

This project is a demonstration of a lightweight Java Spring API that is intended as a service layer for a React/Redux application

# Associated Projects
<ul>
    <li>
        Available API Services:
        <ul>
            <li>Java Spring: https://github.com/WiNTeR270/security-demo-java-api</li>
            <li>C# .NET Core: https://github.com/WiNTeR270/security-demo-.net-core-api</li>
        </ul>
    </li>
    <li>Web Application: https://github.com/WiNTeR270/security-demo-react-redux </li>
</ul>

# Goals of Projects
<ol>
    <li><strong>Create a Simple React/Redux Application</strong>
    <ul>
        <li>Start an empty create-react-app</li>
        <li>Integrate Redux to manage application state</li>
        <li>Integrate Redux middleware (thunk) for allowing async / await dispatch action creators</li>
        <li>Embed OpenLayers map library into a React component</li>
        <li>Integrate UI application with a lightweight .NET Core API</li>
        <li>Demonstrate Redux Reducers</li>
        <li>Demonstrate Redux Actions</li>
        <li>Demonstrate various React components</li>
    </ul>
    </li>
    <li><strong>Create a Simple Java Spring API Service Layer</strong>
    <ul>
        <li>Start with an empty Java Springboot project</li>
        <li>Provide an API for determing if an IP is in a known list (malicious) and retrieve Geo data for IP address</li>
        <li>Integrate Service layer with another external API (ipinfo.io) and converting JSON results</li>
        <li>Integrate Service layer with parsing data from an external URL (binarydefense) and converting raw text results</li>
        <li>Simple unit test exercising API Controller that avoids having to run the full application to test against</li>
        </ul>
    </li>
    <li><strong>Create a Simple .NET Core API Service Layer</strong>
    <ul>
        <li>Start with an empty .NET Core project</li>
        <li>Provide an API for determing if an IP is in a known list (malicious) and retrieve Geo data for IP address</li>
        <li>Integrate Service layer with another external API (ipinfo.io) and converting JSON results</li>
        <li>Integrate Service layer with parsing data from an external URL (binarydefense) and converting raw text results</li>
        <li>Simple unit test exercising API Controller that avoids having to run the full application to test against</li>
        </ul>
    </li>
    <li><strong>Demonstrate CI Pipeline of projects using Travis</strong></li>
</ol>

# How to Run

<ul>
    <li>Install Java JDK 12 and set it to your environment path</li>
    <li>Install Apache Maven and follow instructions: https://maven.apache.org/install.html</li>
    <li>Open up a command line and run the following commands
        <ul>
            <li>Navigate to the root directory (e.g. 'cd DIRECTORY')
            <li>mvn spring-boot:run</li>
        </ul>
    </li>
    <li>Make note of the Tomcat port in use as this will be needed to connect the React UI to this API</li>
</ul>

