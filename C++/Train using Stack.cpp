#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int j = 0, temp, temp1[n], k = (n + 1) / 2, temp2;
    stack<int> stk[k];
    srand(time(0));
    stack<int> output;
    stack<int> input;
    int in = 1;
    for (int i = 0; i < n; i++)
    {
        temp1[i] = -1;
    }
    for (int i = 0; i < n; i++)
    {
        temp = (rand() % n);
        while (temp1[temp] != -1)
        {
            if (temp == (n - 1))
            {
                temp = -1;
            }
            temp++;
        }
        j++;
        temp1[temp] = j;
    }
    for (int i = 0; i < k; i++)
    {
        stk[i].push(-1);
    }
    stack<int> tes;
    for (int i = 0; i < n; i++)
    {
        input.push(temp1[i]);
        tes.push(temp1[i]);
    }
    cout << "Input : ";
    while (!tes.empty())
    {
        cout << tes.top();
        tes.pop();
        if (!tes.empty())
        {
            cout << ", ";
        }
        else
        {
            cout << endl;
        }
    }

    for (int i = 1; i <= n; i++)
    {
        if (input.top() == in)
        {
            output.push(in);
            input.pop();
            in++;
        }
        else
        {
            temp = 0;
            temp2 = input.top();
            while (temp2 == input.top())
            {
                if (stk[temp].top() == -1)
                {
                    stk[temp].push(input.top());
                    input.pop();
                    break;
                }
                else
                {
                    if (stk[temp].top() > input.top())
                    {
                        stk[temp].push(input.top());
                        input.pop();
                        break;
                    }
                    else
                    {
                        temp++;
                    }
                }
            }
        }
    }

    for (int i = in; i <= n; i++)
    {
        temp = 0;
        temp2 = output.top();
        while (temp2 == output.top())
        {
            if (i == stk[temp].top())
            {
                output.push(stk[temp].top());
                stk[temp].pop();
                break;
            }
            else
            {
                temp++;
            }
        }
    }
    cout << "output : ";
    while (!output.empty())
    {
        cout << output.top();
        output.pop();
        if (!output.empty())
        {
            cout << ", ";
        }
        else
        {
            cout << endl;
        }
    }
}
