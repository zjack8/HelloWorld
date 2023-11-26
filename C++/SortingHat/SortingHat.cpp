#include <iostream>
#include <vector>
#include <sstream>
#include <algorithm>

void printArray(const std::vector<int>& arr) {
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

void mergeSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void quickSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void bubbleSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void selectionSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void insertionSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void heapSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

void radixSort(std::vector<int>& arr, int left, int right) {
    // TODO
}

int main(int argc, char* argv[]) {
    std::vector<int> defaultArray = {3, 8, 1, 6, 4, 9, 2, 7, 10, 5};

    // Determine which sorting algorithm to use based on the first argument
    std::string algorithm;
    if (argc > 1) {
        algorithm = argv[1];
    } else {
        std::cerr << "Usage: " << argv[0] << " algorithm \"num1 num2 num3 ...\"" << std::endl;
        return 1;
    }

    // Extract the array elements from the second command-line argument
    std::vector<int> arr;
    if (argc > 2) {
        std::string input = argv[2];
        std::replace(input.begin(), input.end(), '{', ' ');
        std::replace(input.begin(), input.end(), '}', ' ');
        std::istringstream iss(input);
        int num;
        while (iss >> num) {
            arr.push_back(num);
        }
    } else {
        arr = defaultArray;
    }

    std::cout << "Original array: ";
    printArray(arr);

    // Determine which sorting algorithm to use and call the corresponding function
    if (algorithm == "mergeSort") {
        mergeSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "quickSort") {
        quickSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "bubbleSort") {
        bubbleSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "selectionSort") {
        selectionSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "insertionSort") {
        insertionSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "heapSort") {
        heapSort(arr, 0, arr.size() - 1);
    } else if (algorithm == "radixSort") {
        radixSort(arr, 0, arr.size() - 1);
    } else {
        std::cerr << "Invalid algorithm. Supported algorithms: mergeSort, quickSort, bubleSort, selectionSort, insertionSort, heapSort, radixSort" << std::endl;
        return 1;
    }

    std::cout << "Sorted array using " << algorithm << ": ";
    printArray(arr);

    return 0;
}