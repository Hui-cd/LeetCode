#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    for (int i = 0; i < numsSize; ++i) {
        for (int j = i + 1; j < numsSize; ++j) {
            if (nums[i] + nums[j] == target) {
                int* ret = malloc(sizeof(int) * 2);
                ret[0] = i, ret[1] = j;
                *returnSize = 2;
                return ret;
            }
        }
    }
    *returnSize = 0;
    return NULL;
}


int main() {
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int returnSize;

    int* indices = twoSum(nums, numsSize, target, &returnSize);

    if (indices != NULL) {
        printf("Indices of the two numbers that add up to target %d are: %d and %d\n",
               target, indices[0], indices[1]);
        free(indices); // Don't forget to free the allocated memory!
    } else {
        printf("No two numbers add up to the target.\n");
    }

    return 0;
}
