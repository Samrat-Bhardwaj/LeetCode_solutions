# Find the closest pair from two arrays
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given two sorted arrays and a number x, find the pair whose sum is closest to x and&nbsp;the pair has an element from each array. In the case of multiple closest pairs return any one of them.<br>
Note: The output represents the closest difference of the sum with the number x.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> arr[ ] = {1, 4, 5, 7}
brr[ ] = {10, 20, 30, 40} 
X = 32
<strong>Output :</strong> 1
<strong>Explanation:</strong>
The closest pair whose sum is closest
to 32 is {1, 30} = 31.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> arr[ ] = {1, 4, 5, 7}
brr[ ] = {10, 20, 30, 40}
X = 50 <strong>
Output :</strong>  3 
<strong>Explanation:</strong> 
The closest pair whose sum is closest
to 50 is {7, 40} = 47.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function <strong>printClosest()</strong> that takes an array <strong>(arr)</strong>, another array <strong>(brr)</strong>, size of array arr <strong>(N),&nbsp;</strong>size of array brr <strong>(M),</strong>&nbsp;and return the array of two integers whose sum is closest to <strong>X</strong>. The driver code takes care of the printing of the closest difference.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N, M ≤ 10<sup>5</sup><br>
1 ≤ A[i], B[i] ≤ 10<sup>7</sup></span></p>
 <p></p>
            </div>