



function recur(n, cur) {
  if (!cur) {
    cur = 0;
  }
  if (n < 2) {
    throw new Error('Invalid input');
  }
  if (n === 2) {
    return 1 / n + cur;
  }
  return recur(n - 1, cur + 1 / (n * (n - 1)));
}


function recur(n, cur) {

  while (n!=2) {
    x = n - 1;
    y = cur + 1 / (n * (n - 1));
    temp =  1 / x + y;
  }

  return temp;
}

