package hu.paulolajos.daggerhilt.data

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}