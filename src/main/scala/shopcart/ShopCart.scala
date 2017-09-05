package shopcart



object ShopCart {
  
  private val priceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  /*
  Calculates total price of all items in the cart without discount
   */

  def checkout(items: Array[String]): Double = {
    val total = items.flatMap(price).sum
    BigDecimal(total).toDouble 
  }
/*
Retrieve price of item from priceList
 */
  def getPrice
  (item: String): Double = {
    priceList.getOrElse(item toLowerCase(), 0)
  }

  def price(item: String): Option[Double] = priceList.get(item toLowerCase)

  def checkoutWithOffers(items: Array[String]): Double = {
    val noOfApples: Int = items.count(p => p.equalsIgnoreCase("apple"))
    val noOfOranges: Int = items.count(p => p.equalsIgnoreCase("orange"))

    val total = CalculatePrice.calculatePrice("apple")(noOfApples)  + CalculatePrice.calculatePrice("orange")(noOfOranges)
    BigDecimal(total).toDouble
  }


}

