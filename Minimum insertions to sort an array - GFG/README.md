# Minimum insertions to sort an array
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>arr</strong> of size <strong>N</strong>, the task is to sort this array in a minimum number of steps where in one step you can remove any array element from its position and insert it in any other position.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
N = 7
arr[] = {2, 3, 5, 1, 4, 7, 6}
<strong>Output:</strong> 3
<strong>Explanation</strong>: </span>
<span style="font-size:18px">We can sort above array in 3 insertion 
steps as shown below,
1 before array value 2
4 before array value 5
6 before array value 7</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 4
arr[] = {4, 6, 5, 1}
<strong>Output: </strong>2
<strong>Explanation</strong>: 
We can sort above array in 2 insertion 
steps as shown below, 
1 before array value 4
6 after array value 5 </span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong><code>minInsertions</code>()&nbsp;</strong>which takes <strong>N</strong> and array <strong>arr </strong>as input parameters and returns the integer value</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(<strong>N<sup>2</sup></strong>)<br>
<strong>Expected Auxiliary Space:</strong> O(<strong>N</strong>)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>3</sup></span></p>
</div>