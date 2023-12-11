#include <iostream>
#include <vector>
#include <sstream>
#include <algorithm>
#include <chrono>

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
    // Check if the range is valid
    if (left < 0 || right > arr.size() || left >= right) {
        return;
    }

    for (int i = left; i < right - 1; ++i) {
        // Last i elements are already sorted, so we don't need to check them
        for (int j = left; j < right - i - 1; ++j) {
            // Swap if the element found is greater than the next element
            if (arr[j] > arr[j + 1]) {
                std::swap(arr[j], arr[j + 1]);
            }
        }
    }
}

void selectionSort(std::vector<int>& arr, int left, int right) {
    // Check if the range is valid
    if (left < 0 || right > arr.size() || left >= right) {
        return;
    }

    for (int i = left; i < right - 1; ++i) {
        // Assume the current index is the minimum
        int minIndex = i;

        // Find the index of the minimum element in the unsorted part
        for (int j = i + 1; j < right; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Swap the found minimum element with the first unsorted element
        std::swap(arr[i], arr[minIndex]);
    }
}

void insertionSort(std::vector<int>& arr, int left, int right) {
    // Check if the range is valid
    if (left < 0 || right > arr.size() || left >= right) {
        return;
    }

    for (int i = left + 1; i < right; ++i) {
        int key = arr[i];
        int j = i - 1;

        // Move elements that are greater than key to one position ahead
        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            --j;
        }

        // Place the key in its correct position
        arr[j + 1] = key;
    }
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
		std::cerr << "Usage: ./exe algorithm \"num1 num2 num3 ...\"" << std::endl;
		std::cerr << "For more use ./exe -help" << std::endl;
		return 1;
	}

	// Extract the array elements from the second command-line argument
	// If there is no second argument use the default array
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

	if (algorithm == "-help") {
		std::cerr << "Supported algorithms: mergeSort, quickSort, bubbleSort, selectionSort, insertionSort, heapSort, radixSort" << std::endl;
		std::cerr << "Array: \"num1 num2 num3 ...\" or leave blank for default array" << std::endl;
		return 1;
	}

	// Print original array
	std::cout << "Original array: ";
	printArray(arr);

	// Start the timer
	auto start_time = std::chrono::high_resolution_clock::now();

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
		std::cerr << "Invalid algorithm. Supported algorithms: mergeSort, quickSort, bubbleSort, selectionSort, insertionSort, heapSort, radixSort" << std::endl;
		return 1;
	}

	std::cout << "Sorted array using " << algorithm << ": ";
	printArray(arr);

	// Stop the timer
	auto end_time = std::chrono::high_resolution_clock::now();

	// Calculate the duration
	auto duration = std::chrono::duration_cast<std::chrono::microseconds>(end_time - start_time);

	// Print the duration in microseconds
	std::cout << "Time taken by code: " << duration.count() << " microseconds" << std::endl;

	return 0;
}