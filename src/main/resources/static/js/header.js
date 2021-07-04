function httpGet(url)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", url, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function httpPut(url, body)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "PUT", url, false ); // false for synchronous request
    xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(body);
    return xmlHttp.status;
}

function httpPost(url, body)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", url, false ); // false for synchronous request
    xmlHttp.send( body );
    return xmlHttp.responseText;
}

function httpDelete(url,body)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "DELETE", url, false ); // false for synchronous request
    xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(body);
    return xmlHttp.status;
}