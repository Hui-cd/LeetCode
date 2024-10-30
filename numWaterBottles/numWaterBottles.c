int numWaterBottles(int numBottles, int numExchange) {
    int total_drink = numBottles;
    int remain_drink = 0;
    int change_drink  = 0;
    while (numWaterBottles>=numExchange)
    {
        remain_drink = numBottles%numExchage;
        change_drink = numBottles/numExchange
        total_drink += change_drink
        numBottles = remain_drink+change_drink
    }
    return total_drink
}
x