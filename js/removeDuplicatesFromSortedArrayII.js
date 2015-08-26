function removeDuplicates(nums) {
  var length = nums.length;
  if (length === 0) return 0;
  var count = 1, index = 0;
  for (var i = 1; i < length; i++) {
    if (nums[index] === nums[i] && ++count <= 2) {
      nums[++index] = nums[i];
      continue;
    }
    if (nums[index] !== nums[i]) {
      nums[++index] = nums[i];
      count = 1;
    }
  }
  return index + 1;
}
console.log(removeDuplicates([1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 5]));
console.log(removeDuplicates([1, 1]));
