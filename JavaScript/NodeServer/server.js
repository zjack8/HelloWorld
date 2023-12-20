// Import the 'http' module to create an HTTP server.
const http = require('http');

// Configure the HTTP server to respond with "Hello, World!" to all requests.
const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/plain' });
  res.end('Hello Node!\n');
});

// Listen on port 3000 and IP address 127.0.0.1.
const port = 3000;
const ip = '127.0.0.1';
server.listen(port, ip, () => {
  console.log(`Server running at http://${ip}:${port}/`);
});
