Theses tests illustrate some issues (different):

`application.properties` tries to setup a 128K chunk size.

The tests are simple, trying to guess the Chunk size by trying to read the maximum possible.
When debugging, those values are confirmed.

All Servers and Clients use Resteasy Reactive implementations.

Server side (GET to see chunk size from Server):
- Note that on server side, whatever the configuration, the chunk size is limited up to 64KB (can be below but not higher)

Client side (POST to see chunk size from Client):
- ApiTest
  - Uses a "native" injected Resteasy Reactive Client
  - Settings impact client but up to 64KB
- ApiProgrammaticSimpleTest
    - Uses a "native" injected Resteasy Reactive Client
    - Settings impact client but up to 8KB
      - **This is the main issue**
- ApiProgrammaticTest
    - Uses a "native" injected Resteasy Reactive Client
    - Settings impact client but up to 64KB

*The secondary issue is that the limitation for both client and server is 64 KB, whatever the configuration.*
