import sys
input = sys.stdin.readline


def postorder(preorder, inorder):
  if not preorder or not inorder:
    return []

  root = preorder[0]                #전위 순회의 처음 값은 무조건 루트
  root_index = inorder.index(root)  #중위 순회에서 루트값의 인덱스 찾고 인덱스 기준으로 좌 우 트리 나누기

  left_inorder = inorder[:root_index]
  right_inorder = inorder[root_index + 1:]

  left_preorder = preorder[1:1 + len(left_inorder)]
  right_preorder = preorder[1 + len(left_inorder):]

  # 후위 순회는 왼쪽트리 -> 오른쪽트리 -> 루트 순으로 순회
  return postorder(left_preorder, left_inorder) + postorder(right_preorder, right_inorder) + [root]


testcase = int(input().strip())
results = []

for _ in range(testcase):
  n = int(input().strip())
  preorder = list(map(int, input().strip().split()))
  inorder = list(map(int, input().strip().split()))

  result = postorder(preorder, inorder)
  results.append(result)

# print(results)   ->    [[2, 4, 1, 3], [5, 8, 4, 6, 2, 1, 7, 3]]
for result in results:
  print(' '.join(map(str, result)))
