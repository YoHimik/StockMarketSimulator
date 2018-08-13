# StockMarketSimulator

We want to create a stock market simulator with the following components
- 1 x Matching engine
- N x Order books
- 1 x Trade ledger
- 1 x Trading gateway (real exchanges can have multiple trading gateways)

Clients of the stock market will interact with it using Java API. These are the components:
- Matching engine
o &quot;Balances&quot; (like in &quot;balancing the book&quot;, i.e. crossing buys and sells) the order books every 1
second
- Order book(s)
o Contains all orders (buy and sell) for a certain stock
- Trade ledger
o Contains all trades that happen on all books
- Trading gateway
o Allows a client to trade on the market. Exposes these functions:
 add order
 cancel order
o The orders arriving at the trading gateway need to be put into the correct order book

Realization

To interract with user uses to classes: Logger and MainCotroller. Logger has one function(+overload) for writing information to
console and log file. MainController reads and handles user input. Also MainController starts and controlls MatchingEngine thread.
For matching order uses class MatchingEngine, that every one second finds 'buy' order with min price and 'sell' order with max price,
and if 'buy' order price lower than 'sell' order price, then MatchingEngine generates new trade.

