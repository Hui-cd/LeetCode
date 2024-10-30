#include <stdio.h>
#include <stdlib.h>

// Definition of the ListNode
typedef struct ListNode {
    int val;
    struct ListNode *next;
} ListNode;

// Function to find nodes between critical points
void nodesBetweenCriticalPoints(ListNode *head, int *results) {
    if (!head || !head->next || !head->next->next) {
        results[0] = -1;
        results[1] = -1;
        return;
    }
    
    ListNode *prev = head, *curr = head->next, *next = head->next->next;
    int critical_points[100]; // Assuming we won't have more than 100 critical points
    int num_critical = 0;
    int index = 1; // Start from 1 since we're starting from the second node

    // Find critical points
    while (next) {
        if ((curr->val > prev->val && curr->val > next->val) || (curr->val < prev->val && curr->val < next->val)) {
            critical_points[num_critical++] = index;
        }
        prev = curr;
        curr = next;
        next = next->next;
        index++;
    }

    // If there are fewer than two critical points
    if (num_critical < 2) {
        results[0] = -1;
        results[1] = -1;
        return;
    }

    int minDistance = 100000; // Large number to find minimum
    int maxDistance = critical_points[num_critical - 1] - critical_points[0];

    // Calculate minDistance
    for (int i = 1; i < num_critical; i++) {
        int dist = critical_points[i] - critical_points[i - 1];
        if (dist < minDistance) {
            minDistance = dist;
        }
    }

    results[0] = minDistance;
    results[1] = maxDistance;
}

// Helper function to create a new ListNode
ListNode* newNode(int value) {
    ListNode *node = (ListNode*)malloc(sizeof(ListNode));
    node->val = value;
    node->next = NULL;
    return node;
}

// Main function to test the nodesBetweenCriticalPoints
int main() {
    // Creating a test list: 1 -> 3 -> 2 -> 5 -> 2 -> 1
    ListNode *head = newNode(1);
    head->next = newNode(3);
    head->next->next = newNode(2);
    head->next->next->next = newNode(5);
    head->next->next->next->next = newNode(2);
    head->next->next->next->next->next = newNode(1);

    int results[2];
    nodesBetweenCriticalPoints(head, results);

    printf("Min Distance: %d\n", results[0]);
    printf("Max Distance: %d\n", results[1]);

    return 0;
}
