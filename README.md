# Alpha Vantage
## Stock market application

Aplha vantage is an application showcasing the Stock info of listed companies and Market status of different stock 
markets accross the world.

- Uses [Retrofit] to recieve data from Alpha vantage [api]
- Recieves CSV data from api for stock listings and stock history and parses it using [Open CSV]
- Recieves Json data for Company information and parses it using [Moshi]
- Uses Dependency injection with [Dagger Hilt]
- Uses Clean architecture & [S.O.L.I.D] principles
- Uses [Jetpack Compose] for developing native 
- Uses Local Caching by [Room]
- Uses [Compose nav destination] for navigation between different screens
## Features

- [X] Uses bottom bar for easy navigation between the screens.
- [X] First screen shows the market status. 
    - Includes market types like Equity, Forex, Cryptocurrency from all around the world.
    - Swipe to refresh to fetch the latest market status.
    - Last updated info is shown at the top to see the last time the status was refreshed.
- [X] Second screen shows the Company listings
    - Saves the listings in the cache for quick access.
    - Search functionality for searching different companies.
    - Shows information about the company including a cool graph showing the stock history.
- [ ] Third screen contains a currency converter which fetches the latest currency exchange rate (Not yet Implemented)

## Installation

Build the application in Android studio by either downloading as a zip file or clone it directly in the android studio.
There is an APK file also if you directly want to install it in your android phone.

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
[api]: <https://www.alphavantage.co>
[Dagger Hilt]: <https://developer.android.com/training/dependency-injection/hilt-android>
[Open CSV]: <https://opencsv.sourceforge.net>
[Moshi]: <https://github.com/square/moshi>
[S.O.L.I.D]: <https://medium.com/the-android-caf%C3%A9/solid-principles-the-kotlin-way-ff717c0d60da>
[Jetpack Compose]: <https://developer.android.com/jetpack/compose>
[Room]: <https://developer.android.com/training/data-storage/room>
[Compose nav destination]: <https://composedestinations.rafaelcosta.xyz>
[Retrofit]: <https://square.github.io/retrofit/>
